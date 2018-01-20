# Evaluate Databases

## Evaluation Themes

### Basic Bahavior
* create table
* CRUD
* index
* join

### Transactions
* Atomicity
* Consistency
* Isolation
* Durability

### Concurrency
* Blocking for update

### Backup / Restore
* Online Backup
* Full Recovery
* Point-in-time recovery

### Availablity
* Cluster
* Oracle RAC

### Scalability
* Master-Slave

### Network
* Packet Capture

## Target Databases

* See DB-list.ods


## Tests
### Bats
```
sudo add-apt-repository ppa:duggan/bats --yes
sudo apt-get update -qq
sudo apt-get install -qq bats
```

### Groovy