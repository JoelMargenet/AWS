package com.example.myawstest;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.example.myawstest.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Amplify
        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSS3StoragePlugin());

            Amplify.configure(getApplicationContext());
            Log.d("MainActivity", "Amplify initialized successfully!");

            // Save a Person object to AWS DataStore
            savePersonToDataStore();

            // Retrieve Person object from AWS DataStore
            getPersonFromDataStore();

        } catch (Exception e) {
            Log.e("MainActivity", "Error initializing Amplify", e);
        }
    }

    // Function to save a Person object to AWS DataStore
    private void savePersonToDataStore() {
        Person person = new Person("1","John", "Doe");
        Amplify.DataStore.save(
                person,
                result -> Log.d("MainActivity", "Saved item: " + result),
                error -> Log.e("MainActivity", "Error saving item: ", error)
        );
    }

    // Function to retrieve Person object from AWS DataStore
    private void getPersonFromDataStore() {
        Amplify.DataStore.query(
                Person.class,
                items -> {
                    while (items.hasNext()) {
                        Person person = items.next();
                        Log.d("MainActivity", "Retrieved person: " + person);
                    }
                },
                error -> Log.e("MainActivity", "Error retrieving items: ", error)
        );
    }
}
