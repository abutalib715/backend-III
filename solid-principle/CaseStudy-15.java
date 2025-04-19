/*
Background: An application initially uses a local database for user authentication.
Later, it might switch to an external identity provider, such as OAuth or SAML.
The core authentication and authorization logic should remain unaffected by the change in authentication providers.

Question: How would you design the authentication module so that it can integrate different authentication
 providers without needing to modify the main authentication logic?
*/

interface Authenticable {
    public void authenticate();
}

class LocalStorage implements Authenticable {
    public void authenticate() {
        // auth logic
    }
}

class OAuth implements Authenticable {
    public void authenticate() {
        // auth logic
    }
}

class SAML implements Authenticable {
    public void authenticate() {
        // auth logic
    }
}

class AuthenticationProvider {
    private String providerType;

    public void AuthenticationProvider(providerType) {
        this.providerType = providerType;
    }

    public Authenticable getProvider() {
        if (providerType.equals("SAML")) {
            return new SAML();
        } else if (providerType.equals("OAuth")) {
            return new OAuth();
        } else if (providerType.equals("Local")) {
            return new LocalStorage();
        } else {
            return null;
        }
    }
}

class Main() {
    AuthenticationProvider provider = new AuthenticationProvider("OAuth");
    Authenticable authenticable = provider.getProvider();
    authenticable.authenticate();
}