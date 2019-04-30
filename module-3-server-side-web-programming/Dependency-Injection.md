## Dependency Injection ##

### Constructor-Based ###
``` Java
public class ProductDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
```

### Member-Based ###
``` Java
public class ProductDAO {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public ProductDAO() {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
```

### Setter-Based ###
``` Java
public class ProductDAO {

    private JdbcTemplate jdbcTemplate;

    public ProductDAO() {

    }

    @Autowired
    @Qualifier("datasource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
```

## Configuration ##
### XML-Configuration ###
``` XML
<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="org.postgresql.Driver" />
    <property name="url" value="jdbc:postgresql://localhost:5432/dummies" />
    <property name="username" value="postgres" />
    <property name="password" value="postgres1" />
</bean>
```

### Annotation Configuration ###
``` Java
@Configuration
public class DatabaseConfiguration {

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
        return dataSource;
	}
}
```

The benefit of this is that you can chage the dependenies at runtime
``` Java
@Configuration
public class DatabaseConfiguration {

	@Bean
	public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        if(Build.config == Build.DEBUG) {
		// Use the local database
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
	} else {
		// Use the production database
		dataSource.setUrl("jdbc:postgresql://aws.amazon.com:5932/campground");
		dataSource.setUsername(USER_NAME);
		dataSource.setPassword(PASSWORD);
	}

	return dataSource;
    }
}
```