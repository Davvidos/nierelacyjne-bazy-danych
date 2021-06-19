import riak

client = riak.RiakClient()

info = {"name": "Dawid", "lastname": "Jurczyński", "id": "22365", "active": True}

bucket = client.bucket('DB')

record = bucket.new(info["id"], data = info).store()
print(f"Key: {record.key},\nValue: {record.data}")

record = bucket.get(record.key)
print(f"Loaded:\n{record.data}")

data = record.data
data["active"] = False
record.data = data
record.store()

record = bucket.get(record.key)
print(f"Loaded after update:\n{record.data}")

bucket.delete(record.key)
deleted_record = bucket.get(record.key)
print(f"Try to load deleted entry: {deleted_record.data}")
