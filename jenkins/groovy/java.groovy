import hudson.model.JDK
import hudson.tools.InstallSourceProperty
import hudson.tools.ZipExtractionInstaller

def descriptor = new JDK.DescriptorImpl();

def List<JDK> installations = []

javaTools=[['name':'jdk13', 'url':'file:/var/jenkins_home/downloads/openjdk-13.0.2_linux-x64_bin.tar.gz', 'subdir':'jdk-13.0.2'],
      ['name':'jdk9', 'url':'file:/var/jenkins_home/downloads/openjdk-9_linux-x64_bin.tar.gz', 'subdir':'jdk-9']]

javaTools.each { javaTool ->
    println("Setting up tool: ${javaTool.name}")
    def installer = new ZipExtractionInstaller(javaTool.label as String, javaTool.url as String, javaTool.subdir as String);
    def jdk = new JDK(javaTool.name as String, null, [new InstallSourceProperty([installer])])
    installations.add(jdk)

}

descriptor.setInstallations(installations.toArray(new JDK[installations.size()]))
descriptor.save()
