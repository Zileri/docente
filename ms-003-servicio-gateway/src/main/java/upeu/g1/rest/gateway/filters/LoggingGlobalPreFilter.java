package upeu.g1.rest.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
import upeu.g1.rest.gateway.filters.LoggingGlobalPreFilter;

@Component
public class LoggingGlobalPreFilter implements GlobalFilter {
	
	final Logger logger = LoggerFactory.getLogger(LoggingGlobalPreFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Global Pre Filter executed");
		return chain.filter(exchange);
	}		
	
	
	@Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange)
              .then(Mono.fromRunnable(() -> {
                  logger.info("Global Post Filter executed");
              }));
        };
    }
}
