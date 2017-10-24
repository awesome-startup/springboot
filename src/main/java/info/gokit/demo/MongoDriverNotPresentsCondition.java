package info.gokit.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MongoDriverNotPresentsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            Class.forName("com.mongodb.Server");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        }
    }
}
