# workshop-springboot4-jpa — REST API com Spring Boot e JPA/Hibernate

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4-6DB33F?style=flat&logo=springboot&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-Hibernate-59666C?style=flat&logo=hibernate&logoColor=white)
![H2](https://img.shields.io/badge/H2-in--memory-004488?style=flat)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-production-4169E1?style=flat&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-local%20dev-2496ED?style=flat&logo=docker&logoColor=white)
![Railway](https://img.shields.io/badge/Railway-deployed-0B0D0E?style=flat&logo=railway&logoColor=white)
![CRUD](https://img.shields.io/badge/CRUD-completo-4CAF50?style=flat)
![Status](https://img.shields.io/badge/Status-Concluído-4CAF50?style=flat)

Projeto desenvolvido durante o módulo de web services do curso [Java Completo — Udemy](https://github.com/Deduv/curso_udemy-java_completo), instrutor Nelio Alves (DevSuperior).

---

## Sobre o projeto

API REST desenvolvida com Spring Boot 4 e JPA/Hibernate, com modelo de domínio completo envolvendo usuários, pedidos, produtos, categorias e pagamentos. O projeto aplica arquitetura em camadas, CRUD completo e tratamento de exceções customizado. Conta com múltiplos perfis de ambiente e está deployado na nuvem via Railway com banco PostgreSQL.

---

## Deploy

A API está disponível publicamente via Railway:

**Base URL:** `workshop-springboot4-jpa-production.up.railway.app`


## Arquitetura em camadas

```
Resource Layer  →  Service Layer  →  Data Access Layer
(REST controllers)                   (JPA Repositories)
                        ↕
                     Entities
```

---

## Estrutura do proje

```
course/
├── src/main/java/com/example/course/
│   ├── config/
│   │   └── TestConfig.java               # Seed de dados para o perfil de teste
│   ├── entities/
│   │   ├── User.java
│   │   ├── Order.java
│   │   ├── OrderItem.java
│   │   ├── OrderItemPK.java              # Chave composta de OrderItem
│   │   ├── Product.java
│   │   ├── Category.java
│   │   ├── Payment.java
│   │   └── enums/
│   │       └── OrderStatus.java
│   ├── repositories/
│   │   ├── UserRepository.java
│   │   ├── OrderRepository.java
│   │   ├── OrderItemRepository.java
│   │   ├── ProductRepository.java
│   │   └── CategoryRepository.java
│   ├── services/
│   │   ├── UserService.java
│   │   ├── OrderService.java
│   │   ├── ProductService.java
│   │   └── exceptions/
│   │       ├── ResourceNotFoundException.java
│   │       └── DatabaseException.java
│   └── resources/
│       ├── UserResource.java
│       ├── OrderResource.java
│       ├── ProductResource.java
│       └── exceptions/
│           ├── StandardError.java
│           └── ResourceExceptionHandler.java
└── src/main/resources/
    ├── application.properties            # Perfil ativo via variável de ambiente
    ├── application-test.properties       # H2 in-memory
    └── application-dev.properties        # PostgreSQL local via Docker
```

---

## Padrões e conceitos aplicados

| Conceito | Aplicação |
|---|---|
| REST API | Endpoints com `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` |
| Arquitetura em camadas | Resource → Service → Repository, com responsabilidades bem definidas |
| JPA / Hibernate | Mapeamento objeto-relacional com `@Entity`, `@ManyToMany`, `@OneToMany`, `@OneToOne` |
| Chave composta | `@EmbeddedId` com `OrderItemPK` para a associação Order-Product com atributos extras |
| Perfis de ambiente | `test` (H2), `dev` (PostgreSQL via Docker), produção (PostgreSQL Railway) |
| Injeção de dependência | `@Autowired` e `@Service` para desacoplamento entre camadas |
| Tratamento de exceções | `ResourceNotFoundException`, `DatabaseException` e `ResourceExceptionHandler` com `@ControllerAdvice` |
| Database seeding | `@Configuration` + `CommandLineRunner` com `@Profile("test")` |

---

## Fluxo de Deploy

```
IntelliJ (dev)  →  Docker (PostgreSQL local)  →  GitHub  →  Railway (deploy + PostgreSQL nuvem)
```

**Ambiente local:** PostgreSQL rodando via Docker container, perfil `dev` ativo.

**Produção:** Railway vinculado ao repositório GitHub com deploy automático. Variáveis de ambiente configuradas para conexão com o banco PostgreSQL provisionado pelo próprio Railway. Perfil `test` ativado em produção para executar o seed via `TestConfig`.

---

## Tecnologias

| Categoria | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot 4 |
| Persistência | JPA / Hibernate |
| Banco (teste) | H2 in-memory |
| Banco (dev) | PostgreSQL via Docker |
| Banco (produção) | PostgreSQL — Railway |
| Build | Maven |
| Deploy | Railway |
| Servidor | Apache Tomcat (embutido) |
| Testes de API | Postman |
| IDE | IntelliJ IDEA |
| Sistema Operacional | Linux Mint |

---

*Desenvolvido por [Deduv](https://github.com/Deduv) · Graduando em Engenharia de Software*
