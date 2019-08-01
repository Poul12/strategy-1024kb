package pl._1024kb.strategy.scopes;

import pl._1024kb.strategy.ScopeStrategy;

public class TeamScope implements ScopeStrategy {
    @Override
    public int maxNumber() {
        return 25;
    }
}
