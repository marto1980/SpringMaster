#!/bin/ksh

# Abbruch, wenn kein Projektname übergeben wurde
if [[ -z "$1" ]]; then
  echo "Usage: $0 <ProjectName>"
  exit 1
fi

PROJECT_NAME=$1
GROUP_ID="com.marto"
ARTIFACT_ID="$PROJECT_NAME"

# Ranga nutzt im Kurs das Paket "webapp", das behalten wir bei
FULL_PACKAGE="webapp"
PACKAGE_DIR="webapp"

echo "--- Generiere Tomcat Web-Projekt für Java 25: $ARTIFACT_ID ---"

# 1. Standard-Verzeichnisstruktur anlegen
mkdir -p "$ARTIFACT_ID/src/main/java/$PACKAGE_DIR"
mkdir -p "$ARTIFACT_ID/src/main/webapp/WEB-INF"

# 2. pom.xml mit dem modernisierten Jetty-Plugin schreiben
cat <<EOF >"$ARTIFACT_ID/pom.xml"
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>$GROUP_ID</groupId>
    <artifactId>$ARTIFACT_ID</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>war</packaging>

    <properties>
        <maven.compiler.source>25</maven.compiler.source>
        <maven.compiler.target>25</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- Die moderne Jakarta Servlet-API (Ersatz für das alte javax.servlet) -->
        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>6.1.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Compiler Plugin konfiguriert für Java 25 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
            </plugin>
            <!-- War Plugin zum Paketieren der Web-App -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.4.0</version>
            </plugin>
            <!-- Modern Jetty 12 EE10 Plugin for Java 25 / Jakarta EE 10 compatibility -->
            <plugin>
                <groupId>org.eclipse.jetty.ee10</groupId>
                <artifactId>jetty-ee10-maven-plugin</artifactId>
                <version>12.1.10</version>
                <configuration>
                    <webApp>
                        <contextPath>/</contextPath>
                    </webApp>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
EOF

# 3. LoginServlet.java erzeugen (angepasst auf moderne jakarta.* Imports)
cat <<'EOF' >"$ARTIFACT_ID/src/main/java/webapp/LoginServlet.java"
package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * Jakarta EE with Servlets
 * 
 * Web Server responds with Http Response
 */

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Yahoo!!!!!!!!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("My First Modern Jetty Servlet via Java 25!");
		out.println("</body>");
		out.println("</html>");
	}
}
EOF

# 4. web.xml erzeugen (Aktualisiert auf Jakarta XML Namespace)
cat <<'EOF' >"$ARTIFACT_ID/src/main/webapp/WEB-INF/web.xml"
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">

	<display-name>To do List</display-name>

	<welcome-file-list>
		<welcome-file>login.do</welcome-file>
	</welcome-file-list>

</web-app>
EOF

if [[ $? -eq 0 ]]; then
  echo "\n--- Projekt erfolgreich erstellt! ---"
  echo "Nächste Schritte:"
  echo "1. cd $ARTIFACT_ID"
  echo "2. Projekt in LazyVim öffnen: nvim ."
  echo "3. Jetty-Server starten mit dem Befehl:"
  echo "   mvn jetty:run"
  echo "4. Im Browser aufrufen: http://localhost:8080/login.do"
fi
