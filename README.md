# About this project 
It has a library that keep a count for activities you access and may report to an api

## How to use it
apply this code to all Activities in onCreate lifecycle call

```
    override fun onCreate(savedInstanceState: Bundle?) {

            .....

            // when Activity starts it reports in onCreate method that it has been accessed
            ScreenChanges.report(this)
        }
```
