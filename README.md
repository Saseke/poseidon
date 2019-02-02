# Poseidon

## 说明

> Poseidon采用微服务架构方式,基于SpringCloud+SpringBoot+Mybatis Plus的商城系统。主要包括包括前台商城系统和后台管理系统。
>
> 如果该项目对您有帮助，您可以点一下右上角的"star" 支持一下 谢谢!
>
> 或者可以"follow"一下,该项目会一直持续更新,不断添加新功能和优化

## 组织结构

```
Poseidon
├── psd-config -- 通用配置
├── psd-discovery -- Eureka注册中心
├── psd-elastic-search -- 基于Elasticsearch的商品搜索,推荐服务
├── psd-gateway -- 网关服务
├── psd-generate -- 采用Mybatis Generator自动生成代码
├── psd-member -- 用户服务
├── psd-web-auth -- JWT用户登录服务
├── psd-web-shop-cart -- 购物车服务
└── psd-web-view -- 商品展示服务
```

## 所用技术

### 后端技术

|     技术名称     |        说明        |                    链接                     |
| :--------------: | :----------------: | :-----------------------------------------: |
|   SpringCloud    |   微服务构建框架   |   http://spring.io/projects/spring-cloud    |
|    SpringBoot    |    容器+MVC框架    |   https://spring.io/projects/spring-boot    |
|     Mybatis      |      ORM框架       |      http://www.mybatis.org/mybatis-3       |
| MybatisGenerator | 文件结构和代码生成 |                                             |
|   MybatisPlus    |    Mybatis增强     |           https://mp.baomidou.com           |
|    Swagger-UI    |    文档生产工具    | <https://github.com/swagger-api/swagger-ui> |
|  Elasticsearch   |      搜索引擎      |           https://www.elastic.co            |
|     RabbitMq     |      消息队列      |         <https://www.rabbitmq.com/          |
|      Redis       |     分布式缓存     |              https://redis.io               |
|      Druid       |    数据库连接池    |      https://github.com/alibaba/druid       |
|      Docker      |       容器化       |             https://docker.com              |
|     JWT验证      |      JWT登录       |               https://jwt.io                |

### 前端技术

| 技术名称 |   说明   |        链接         |
| :------: | :------: | :-----------------: |
|  React   | 前端框架 | https://reactjs.org |

