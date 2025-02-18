FROM payara/server-web:6.2024.9-jdk17
COPY target/jms-practice.war $DEPLOY_DIR
