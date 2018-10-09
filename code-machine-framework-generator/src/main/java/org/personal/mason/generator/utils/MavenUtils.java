package org.personal.mason.generator.utils;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.building.ModelBuildingException;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileInputStream;
import java.io.IOException;

import static org.springframework.util.ObjectUtils.isEmpty;

public abstract class MavenUtils {

    public static void main(String[] args) throws Exception {
        readPom();
    }

    public static void readPom() throws IOException, XmlPullParserException, ModelBuildingException {
        String basedir = "/Users/mason/Workspaces/work/code-machine-framework/";
        String pomFileName = "pom.xml";

        Model model = new MavenXpp3Reader().read(new FileInputStream(basedir + pomFileName));
        model.getModules().forEach(System.out::println);
        System.out.println(model.getParent().getRelativePath());
        Model parentModel = new MavenXpp3Reader().read(new FileInputStream(basedir + model.getParent().getRelativePath()));
        if (isEmpty(model.getGroupId())) {
            model.setGroupId(parentModel.getGroupId());
        }
        if (isEmpty(model.getVersion())) {
            model.setVersion(parentModel.getVersion());
        }
        parentModel.getDependencyManagement().getDependencies().forEach(dependency -> System.out.println(dependency.getManagementKey()));
        model.getModules().forEach(module -> {
            try {
                Model moduleModel = new MavenXpp3Reader().read(new FileInputStream(basedir + module + '/' + pomFileName));
                Dependency dependency = new Dependency();
                dependency.setArtifactId(module);
                dependency.setVersion(model.getParent().getVersion());
                dependency.setGroupId(model.getGroupId());
                parentModel.getDependencyManagement().addDependency(dependency);
                moduleModel.getDependencies().forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        });
        parentModel.getDependencyManagement().getDependencies().forEach(dependency -> System.out.println(dependency.toString()));
    }
}
