
abstract class MyDatabase: RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java, "my_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }
}

