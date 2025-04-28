/*
Dynamic Pricing Engine for Finance
Scenario:
Design a pricing engine for derivatives that supports different asset classes (options, swaps, futures).
Pricing algorithms vary greatly and depend on external data feeds.
Each algorithm has its own validation, audit trail, and caching strategy.

Question:
How do you define pricing behavior without hardcoding it?
How do you plug in different audit or caching strategies without tight coupling?
How do you support composable pricing logic?
*/

interface PricingAlgorithm {
    public boolean validate(Dataset dataset);

    public void audit();

    public void caching();

    void setValidator(Validator validator);

    void setAuditLogger(AuditLogger auditLogger);

    void setCacheProvider(CacheProvider cacheProvider);
}

interface Validator {
    public boolean validate(Dataset dataset);
}

interface AuditLogger {
    public void audit();
}

interface CacheProvider {
    public void cache();
}


class StrictValidator implements Validator {

    public boolean validate(Dataset dataset) {
        // STRICT VALIDATOR
        return true;
    }
}

class DatabaseAuditLogger implements AuditLogger {
    public void audit() {
        // DB AUDIT
    }
}

class RedisCacheProvider implements CacheProvider {
    public void cache() {
        // CACHING
    }
}


class OptionsPricing implements PricingAlgorithm {
    private Validator validator;
    private AuditLogger auditLogger;
    private CacheProvider cacheProvider;

    public OptionsPricing(Validator validator, AuditLogger auditLogger, CacheProvider cacheProvider) {
        this.validator = validator;
        this.auditLogger = auditLogger;
        this.cacheProvider = cacheProvider;
    }

    public boolean validate(Dataset dataset) {
        validator.validate(dataset);
    }

    public void audit() {
        auditLogger.audit();
    }

    public void caching() {
        cacheProvider.cache();
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public void setAuditLogger(AuditLogger auditLogger) {
        this.auditLogger = auditLogger;
    }

    public void setCacheProvider(CacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }
}

class SwapPricing implements PricingAlgorithm {
    private Validator validator;
    private AuditLogger auditLogger;
    private CacheProvider cacheProvider;

    public SwapPricing(Validator validator, AuditLogger auditLogger, CacheProvider cacheProvider) {
        this.validator = validator;
        this.auditLogger = auditLogger;
        this.cacheProvider = cacheProvider;
    }

    public boolean validate(Dataset dataset) {
        validator.validate(dataset);
    }

    public void audit() {
        auditLogger.audit();
    }

    public void caching() {
        cacheProvider.cache();
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public void setAuditLogger(AuditLogger auditLogger) {
        this.auditLogger = auditLogger;
    }

    public void setCacheProvider(CacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }
}

class FuturesPricing implements PricingAlgorithm {
    private Validator validator;
    private AuditLogger auditLogger;
    private CacheProvider cacheProvider;

    public FuturesPricing(Validator validator, AuditLogger auditLogger, CacheProvider cacheProvider) {
        this.validator = validator;
        this.auditLogger = auditLogger;
        this.cacheProvider = cacheProvider;
    }

    public boolean validate(Dataset dataset) {
        validator.validate(dataset);
    }

    public void audit() {
        auditLogger.audit();
    }

    public void caching() {
        cacheProvider.cache();
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public void setAuditLogger(AuditLogger auditLogger) {
        this.auditLogger = auditLogger;
    }

    public void setCacheProvider(CacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }
}


class PricingController {
    public void main() {
        Dataset dataset = new Dataset();
        PricingStrategy pricingStrategy = new PricingStrategy();
        PricingAlgorithm pricingAlgorithm = pricingStrategy.getPricingStrategy("swap");
        pricingAlgorithm.setValidator(new StrictValidator());
        pricingAlgorithm.setAuditLogger(new DatabaseAuditLogger());
        pricingAlgorithm.setCacheProvider(new RedisCacheProvider());
        pricingAlgorithm.validate(dataset);
        pricingAlgorithm.audit();
        pricingAlgorithm.caching();
    }
}

class PricingStrategy {
    public PricingAlgorithm getPricingStrategy(String type) {
        if (type.equals("options")) {
            return new OptionsPricing();
        } else if (type.equals("swap")) {
            return new SwapPricing();
        } else if (type.equals("swap")) {
            return new FuturesPricing();
        } else
            throw new Exception("Unknown pricing strategy!");
    }
}