
//Background: You need to build a rest API where User can login and logout, User can upload a csv file with keyword.
//With each keyword software should perform a search to google with a network call.
//Result from the network call should be stored in database
//
//Question: What are the classes you might need in this software solution?

//Ans:
//AuthController ->LoginRequestValidator ->AuthService ->User
//AuthController ->LogoutRequestValidator ->AuthService ->User
//UploadController ->UploadValidator ->UploadService ->SearchJob ->SearchCompletedEvent ->StoreToDbJob->SearchResult


public class AuthCotroller {
    login(LoginRequestValidator loginRequestValidator) {
    }

    logout(LogoutRequestValidator logoutRequestValidator) {
    }
}


public class AuthService {
    login() {
    }

    logout() {
    }
}

public class LoginRequestValidator {
    public validate()
}

public class LogoutRequestValidator {
    public validate()
}

public class User {
    // ser entity here
}



public class UploadController {
    uploadFile(UploadValidator uploadValidator) {
    }
}

public class UploadService {
    uploadFile() {
    }

    processKeyword(){
        foreachkeyword {
            searchJob()
        }
    }
}

public class SearchJob {
    private final ApplicationEventPublisher eventPublisher;

    searchJob() {

        // Publish the event
        eventPublisher.SearchCompletedEvent(new SearchCompletedEvent(this));
    }
}

public class SearchCompletedEvent extends ApplicationEvent {
    public SearchCompletedEvent(Object source) {
        super(source);
    }
}

public class SearchCompletedEventListner {
    @EventListner
    handleSearchCompletedEvent() {
        // STORE RESULT TO DB
    }
}

public class SearchResult {
    // ser entity here
}





