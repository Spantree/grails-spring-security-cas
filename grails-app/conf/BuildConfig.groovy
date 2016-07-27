grails.project.work.dir = 'target'
grails.project.docs.output.dir = 'docs/manual' // for backwards-compatibility, the docs are checked into gh-pages branch

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
		mavenRepo 'http://repo.spring.io/milestone' // TODO remove
		mavenRepo "https://repo.grails.org/grails/plugins"
		mavenRepo "https://css.bintray.com/maven-public"
	}

	dependencies {
		String springSecurityVersion = '3.2.0.RC1'

		compile "org.springframework.security:spring-security-cas:$springSecurityVersion", {
			excludes 'cas-client-core', 'commons-logging', 'ehcache', 'fest-assert', 'jcl-over-slf4j', 'junit',
			         'logback-classic', 'mockito-core', 'spring-beans', 'spring-context', 'spring-core',
			         'spring-security-core', 'spring-security-web', 'spring-test', 'spring-web', 'tomcat-servlet-api'
		}

		compile 'org.jasig.cas.client:cas-client-core:3.2.1', {
			excludes 'commons-codec', 'commons-logging', 'junit', 'log4j', 'opensaml', 'servlet-api',
			         'spring-beans', 'spring-context', 'spring-core', 'spring-test', 'xmlsec'
		}

        compile "org.springframework.security:spring-security-core:$springSecurityVersion", {
            excludes 'aopalliance', 'aspectjrt', 'cglib-nodep', 'commons-collections', 'commons-logging',
                    'ehcache', 'fest-assert', 'hsqldb', 'jcl-over-slf4j', 'jsr250-api', 'junit',
                    'logback-classic', 'mockito-core', 'powermock-api-mockito', 'powermock-api-support',
                    'powermock-core', 'powermock-module-junit4', 'powermock-module-junit4-common',
                    'powermock-reflect', 'spring-aop', 'spring-beans', 'spring-context', 'spring-core',
                    'spring-expression', 'spring-jdbc', 'spring-test', 'spring-tx'
        }

        compile "org.springframework.security:spring-security-web:$springSecurityVersion", {
            excludes 'aopalliance', 'commons-codec', 'commons-logging', 'fest-assert', 'groovy', 'hsqldb',
                    'jcl-over-slf4j', 'junit', 'logback-classic', 'mockito-core', 'powermock-api-mockito',
                    'powermock-api-support', 'powermock-core', 'powermock-module-junit4',
                    'powermock-module-junit4-common', 'powermock-reflect', 'spock-core', 'spring-aop',
                    'spring-beans', 'spring-context', 'spring-core', 'spring-expression', 'spring-jdbc',
                    'spring-security-core', 'spring-test', 'spring-tx', 'spring-web', 'spring-webmvc',
                    'tomcat-servlet-api'
        }
	}

	plugins {
		compile ':spring-security-core:2.0-RC2-SPANTREE'

		compile ":hibernate:$grailsVersion", {
			export = false
		}

		build ':release:2.2.1', ':rest-client-builder:1.0.3', {
			export = false
		}
	}
}
