package pl._1024kb.strategy.scopes;

import pl._1024kb.strategy.ScopeStrategy;

public class GroupScope implements ScopeStrategy {
    @Override
    public int maxNumber() {
        return 40;
    }
}
