printjson(
    db.people.aggregate(
        [
            {
                "$addFields": {
                    credit: {
                        "$map": {
                            input: "$credit",
                            in: {
                                "$mergeObjects": [
                                    "$$this",
                                    {
                                        "convertedBalance": {
                                            "$toDecimal": "$$this.balance"
                                        }
                                    }
                                ]
                            }
                        }
                    }
                }
            },
            {
                $unwind: "$credit"
            },
            {
                $group:
                    {
                        _id: "$credit.currency",
                        balance: {
                            $sum: "$credit.convertedBalance"
                        }
                    }
            }
        ]
    ).toArray()
)
