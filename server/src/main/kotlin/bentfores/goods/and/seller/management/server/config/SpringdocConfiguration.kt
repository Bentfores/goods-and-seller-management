package bentfores.goods.and.seller.management.server.config

import org.springdoc.core.configuration.SpringDocConfiguration
import org.springdoc.core.configuration.SpringDocUIConfiguration
import org.springdoc.core.properties.SpringDocConfigProperties
import org.springdoc.core.properties.SwaggerUiConfigProperties
import org.springdoc.core.providers.ObjectMapperProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.util.Optional

@Configuration
class SpringdocConfiguration {

  @Bean
  @Primary
  fun springDocConfiguration(): SpringDocConfiguration {
    return SpringDocConfiguration()
  }

  @Bean
  fun springDocConfigProperties(): SpringDocConfigProperties {
    return SpringDocConfigProperties()
  }

  @Bean
  fun objectMapperProvider(springDocConfigProperties: SpringDocConfigProperties): ObjectMapperProvider {
    return ObjectMapperProvider(springDocConfigProperties)
  }

  @Bean
  fun springDocUIConfiguration(
    optionalSwaggerUiConfigProperties: Optional<SwaggerUiConfigProperties?>?
  ): SpringDocUIConfiguration {
    return SpringDocUIConfiguration(optionalSwaggerUiConfigProperties)
  }
}
