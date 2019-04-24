package com.derun.jczb;

import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import javax.servlet.MultipartConfigElement;

@Configuration
public class HttpsConfig {
	

	 @Value("${https.ssl.key-store}")
	 private String path;
	 @Value("${https.ssl.key-store-password}")
	 private String password;
	 @Value("${https.port}")
	 private int port;
	 @Value("${http.port}")
	 private int http_port;	 
	    /**
	     * 通过构造工厂造1个jetty
	     */
	    @Bean
	    public ServletWebServerFactory servletContainer() {
	        JettyServletWebServerFactory jetty = new JettyServletWebServerFactory();
	        customizeJetty(jetty);
	        return jetty;
	    }
	 
	    /**
	     * 为jetty服务器开通http端口和https,并配置线程
	     */
	    private void customizeJetty(JettyServletWebServerFactory container) {
	        container.addServerCustomizers((Server server) -> {
	            //配置线程
	            threadPool(server);
	 
	            // 添加HTTP配置
	            ServerConnector connector = new ServerConnector(server);
//	            System.out.println("端口:  "+http_port);
	            connector.setPort(http_port);
	 
	            // 添加HTTPS配置
	            SslContextFactory sslContextFactory = new SslContextFactory();
	            sslContextFactory.setKeyStorePath(path);
	            sslContextFactory.setKeyStorePassword(password);
	 
	            HttpConfiguration config = new HttpConfiguration();
	            config.setSecureScheme(HttpScheme.HTTPS.asString());
	            config.addCustomizer(new SecureRequestCustomizer());
	 
	            ServerConnector sslConnector = new ServerConnector(
	                    server,
	                    new SslConnectionFactory(sslContextFactory, HttpVersion.HTTP_1_1.asString()),
	                    new HttpConnectionFactory(config));
	            sslConnector.setPort(port);
	            server.setConnectors(new Connector[]{connector, sslConnector});
	        });
	    }
	 
	    /**
	     * jetty线程配置
	     */
	    private void threadPool(Server server) {
	        // connections
	        final QueuedThreadPool threadPool = server.getBean(QueuedThreadPool.class);
	        //默认最大线程连接数200
	        threadPool.setMaxThreads(300);
	        //默认最小线程连接数8
	        threadPool.setMinThreads(15);
	        //默认线程最大空闲时间60000ms
	        threadPool.setIdleTimeout(60000);
	    }
	 
	    /**
	     * 配置文件上传
	     */
	    @Bean
	    MultipartConfigElement multipartConfigElement() {
	        MultipartConfigFactory factory = new MultipartConfigFactory();
	        //  单个数据大小
	        factory.setMaxFileSize("100MB"); // KB,MB
	        /// 总上传数据大小
	        factory.setMaxRequestSize("200MB");
	        return factory.createMultipartConfig();
	    }
}
