package com.example.edwinb.agiletrailblazers.Configuration;

import com.example.edwinb.agiletrailblazers.Dagger.App;

/**
 * A Data Manager class will check to see if the information being retrieved is already cached in file storage.  If it is
 * then the file will be parsed and the info will be returned, if it isn't the service will be called with a ServiceListener
 * passed in to handle the service response for the call.
 */
public class DataManager {

    public DataManager(App app) {
        app.getComponent().inject(this);
    }

    /**
     * Create a wrapper listener for a ServiceListener that calls the
     * handleResponse method of the ServiceListener.
     * @param //file
     * @param listener
     * @return
     */

    protected ServiceListener createListener(final ServiceListener listener) {
        return new ServiceListener() {
            @Override
            public void handleResponse(Object response) {
                listener.handleResponse(response);
            }
        };
    }
}
