# 一 加入 maven 编译工具 
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <version>2.3.2</version>
                        <configuration>
                            <source>1.8</source>
                            <target>1.8</target>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
            
            
# 一 加入 MybatisPlus 依赖             
            <!--  引入 MybatisPlus 依赖 -->
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>3.0-RC3</version>
            </dependency>
            <!--  引入 jackson 依赖 -->       
            <dependency>
                <groupId>com.fasterxml.jackson.core</groupId>
                <artifactId>jackson-databind</artifactId>
                <version>RELEASE</version>
                <scope>compile</scope>
            </dependency>