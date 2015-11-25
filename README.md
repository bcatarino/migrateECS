
Migrates all elastic search indexes from one Amazon Account to another

# How to set up
1) Locate your application.properties file.
2) Replace the amazon key, secret and domain with the ones for the accounts you want to use.

# What you can do with it
## IndexDescriber
Run as a java application to get the json that describes the indexes in your source amazon account.

##IndexReplicator
Run as a java application to fully migrate every index from your source account to your target account.

#     
This is a pretty basic implementation that suits my needs. Feel free to use it as it is or improve it.
