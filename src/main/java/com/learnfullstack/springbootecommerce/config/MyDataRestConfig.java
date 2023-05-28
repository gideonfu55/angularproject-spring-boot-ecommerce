package com.learnfullstack.springbootecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.learnfullstack.springbootecommerce.entity.Product;
import com.learnfullstack.springbootecommerce.entity.ProductCategory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

  private EntityManager entityManager;
  
  public MyDataRestConfig(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }
  
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

    // disable HTTP methods for Product: PUT, POST and DELETE (just read-only for now):
    config.getExposureConfiguration()
      .forDomainType(Product.class)
      .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
      .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

    // disable HTTP methods for ProductCategory: PUT, POST and DELETE (just read-only for now):
    config.getExposureConfiguration()
        .forDomainType(ProductCategory.class)
        .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

    // call an internal helper method
    exposeIds(config);
  }

  private void exposeIds(RepositoryRestConfiguration config) {
    // expose entity ids

    // - get a list of all entity classes from the entity manager
    Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

    // - create an array of the entities types
    List<Class<?>> entityClasses = new ArrayList<>();

    // - get the entity types for the entities
    for (EntityType<?> entityType : entities) {
      entityClasses.add(entityType.getJavaType());
    }

    // - expose the entity ids for the array of entity/domain types
    Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
    config.exposeIdsFor(domainTypes);
  }
}
