package com.magewr.micro_crawler.data;

import com.magewr.micro_crawler.data.remote.RemoteRepository;

public class DataManager {
    private RemoteRepository remoteRepository;

    public DataManager() {
        remoteRepository = new RemoteRepository();
    }

    public RemoteRepository getRemoteRepository() {
        return remoteRepository;
    }
}
