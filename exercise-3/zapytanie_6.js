printjson(
    db.people.insert(
        {
            "sex" : "Male",
            "first_name" : "Dawid",
            "last_name" : "Jurczyński",
            "job" : "PHP Developer",
            "email" : "s22365@pjwstk.edu.pl",
            "location" : {
                "city" : "Warsaw",
                "address" : {
                    "streetname" : "Koszykowa",
                    "streetnumber" : "86"
                }
            },
            "description" : "Lorem ipsum dolor sit amet",
            "height" : "182.00",
            "weight" : "80.0",
            "birth_date" : "1995-12-10T09:00:00Z",
            "nationality" : "Poland",
            "credit" : [
                {
                    "type" : "abc",
                    "number" : "5163095807747128",
                    "currency" : "PLN",
                    "balance" : "1000.00"
                }
            ]
        }
    )
)
