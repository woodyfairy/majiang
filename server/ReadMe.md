部署说明
1. 修改server/apache-tomcat-7.0.82/conf/server.xml中的docBase,workDir配置
<Context path="" reloadable="true" docBase="/root/majiang/server/GameServer-MJ/WebRoot" workDir="/root/majiang/server/GameServer-MJ/work" />
2. 修改数据库配置
server/GameServer-MJ/WebRoot/WEB-INF/classes/myBatisConfig.xml
3. 修改
server\GameServer-MJ\ibatis-generator-config.xml
在自动生成文件之后。
修改roomInfo的数据库id自增支持
server\GameServer-MJ\src\com\dyz\myBatis\sqlMapper\RoominfoMapper.xml
server\GameServer-MJ\WebRoot\WEB-INF\classes\com\dyz\myBatis\sqlMapper\RoominfoMapper.xml
<insert id="insertSelective" parameterType="com.dyz.myBatis.model.Roominfo">
改为
<insert id="insertSelective" parameterType="com.dyz.myBatis.model.Roominfo" keyProperty="id" useGeneratedKeys="true">
4. 注意.gitignore文件不要把编译生成的WEB-INF忽略掉。

3.启动和关闭
bin/startup.sh
bin/shutdown.sh
