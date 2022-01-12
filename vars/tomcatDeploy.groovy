def call(credId,tomcatIp,tomcatUser)
{
  sshagent(['credId']) {
                    // some block
                    sh """                    
                    scp -o StrictHostKeyChecking=no target/myweb-0.0.6.war ${tomcatUser}@${tomcatIp}:/opt/tomcat8/webapps/myweb.war
                    ssh  ${tomcatUser}@${tomcatIp} /opt/tomcat8/bin/shutdown.sh
                    ssh  ${tomcatUser}@${tomcatIp} /opt/tomcat8/bin/startup.sh
                    
                    """
                }
}
