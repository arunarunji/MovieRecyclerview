package com.example.listview

import android.content.res.Resources

class AppData(resources: Resources) {

    var names: Array<String>
    var lastnames: Array<String>
    var genders: Array<String>
    var nationalities: Array<String>

    var resources: Resources

    var people: MutableList<Person>

    init {
        this.resources = resources
        names = resources.getStringArray(R.array.names)
        lastnames = resources.getStringArray(R.array.lastnames)
        genders = resources.getStringArray(R.array.gender)
        nationalities = resources.getStringArray(R.array.nationality)
        people = mutableListOf()
        for (i in names.indices) {
            val person = Person(
                names[i], lastnames[i],
                if (genders[i].equals(
                        "male",
                        ignoreCase = true
                    )
                ) Person.Gender.MALE else Person.Gender.FEMALE,
                nationalities[i]
            )
            people.add(person)
        }
    }

    companion object {

        private lateinit var appData: AppData
        fun getAppData(resources: Resources): AppData {
            if (!this::appData.isInitialized) {
                appData = AppData(resources)
            }
            return appData
        }


    }
}