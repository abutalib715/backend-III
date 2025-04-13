/*
Background: An e-commerce system stores order data in a SQL database. Later, there may be a need to switch to a
NoSQL database or another storage method for scalability. The high-level order processing logic should remain
unaffected by these changes.
Question: How would you structure the data persistence layer for order data so that the core order processing
logic can work with any storage type without modification?*/


interface DataStorage {
    storeData();
}

class MySqlStorage implements DataStorage {
    storeData(); // Data storage logic
}

class NoSqlStorage implements DataStorage {
    storeData(); // Data storage logic
}

class FileStorage implements DataStorage {
    storeData(); // Data storage logic
}

class OrderService {
    DataStorage dataStorage;

    OrderService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    processOrder() {
        dataStorage.storeData();
    }
}