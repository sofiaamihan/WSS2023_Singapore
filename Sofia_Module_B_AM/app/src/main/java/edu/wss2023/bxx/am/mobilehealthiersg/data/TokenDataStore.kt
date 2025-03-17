package edu.wss2023.bxx.am.mobilehealthiersg.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenDataStore(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("session_token")
        var NAME1 = stringPreferencesKey("NAME1")
        var CONTACT1 = stringPreferencesKey("CONTACT1")
        var RELATIONSHIP1 = stringPreferencesKey("RELATIONSHIP1")
        var NAME2 = stringPreferencesKey("NAME2")
        var CONTACT2 = stringPreferencesKey("CONTACT2")
        var RELATIONSHIP2 = stringPreferencesKey("RELATIONSHIP2")
    }

    var getName1: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[NAME1] ?: ""
        }

    var getName2: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[NAME2] ?: ""
        }

    var getContact1: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[CONTACT1] ?: ""
        }

    var getContact2: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[CONTACT2] ?: ""
        }

    var getRelationship1: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[RELATIONSHIP1] ?: ""
        }

    var getRelationship2: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[RELATIONSHIP2] ?: ""
        }

    suspend fun saveName1(name: String){
        context.dataStore.edit { preferences ->
            preferences[NAME1] = name
        }
    }

    suspend fun saveName2(name: String){
        context.dataStore.edit { preferences ->
            preferences[NAME2] = name
        }
    }

    suspend fun saveContact1(contact: String){
        context.dataStore.edit { preferences ->
            preferences[CONTACT1] = contact
        }
    }

    suspend fun saveContact2(contact: String){
        context.dataStore.edit { preferences ->
            preferences[CONTACT2] = contact
        }
    }

    suspend fun saveRelationship1(rs: String){
        context.dataStore.edit { preferences ->
            preferences[RELATIONSHIP1] = rs
        }
    }

    suspend fun saveRelationship2(rs: String){
        context.dataStore.edit { preferences ->
            preferences[RELATIONSHIP2] = rs
        }
    }
}