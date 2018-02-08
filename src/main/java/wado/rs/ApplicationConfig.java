package wado.rs;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(UsersRS.class);
		resources.add(ProjectsRS.class);
	}

	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}
}
