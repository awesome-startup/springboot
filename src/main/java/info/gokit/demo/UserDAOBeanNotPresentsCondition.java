package info.gokit.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UserDAOBeanNotPresentsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        UserDAO userDAO = context.getBeanFactory().getBean(UserDAO.class);
        return (userDAO == null);
    }
}
