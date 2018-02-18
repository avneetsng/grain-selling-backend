package com.prayasj.gndit.grainselling.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
  @Value("${app.auth.secret}")
  @Getter
  private String secret;
}
