//
//  BMCAppDelegate.m
//  BankerMatchCheker
//
//  Created by Yuki Toyoshima on 2013/07/28.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import "BMCAppDelegate.h"

@implementation BMCAppDelegate

@synthesize managedObjectContext = _managedObjectContext;
@synthesize managedObjectModel = _managedObjectModel;
@synthesize persistentStoreCoordinator = _persistentStoreCoordinator;

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    // Override point for customization after application launch.
    return YES;
}
							
- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later. 
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}


#pragma mark - Core Data stack

// Returns the managed object context for the application.
// If the context doesn't already exist, it is created and bound to the persistent store coordinator for the application.
//
//persistent store coodinatorとは、SQLiteデータベースの保存場所の設定、モデルエディタとデータベースとの関連を設定する。
//
- (NSManagedObjectContext *)managedObjectContext
{
    //mocがnullでなければmocのオブジェクトを返還
    if (_managedObjectContext != nil) {
        return _managedObjectContext;
    }
    
    //npcオブジェクトを取得
    NSPersistentStoreCoordinator *coordinator = [self persistentStoreCoordinator];
    //nullでなければ
    if (coordinator != nil) {
        //mocオブジェクトを生成
        _managedObjectContext = [[NSManagedObjectContext alloc] init];
        //mocにpscをセット
        //psに対して変更を与えるのがmoc
        //おそらくその為にDBの情報等が必要でそれを持っているpscをセットするという流れ
        [_managedObjectContext setPersistentStoreCoordinator:coordinator];
    }
//    pscをセットしてあるmocを返却する
    return _managedObjectContext;
}

// Returns the managed object model for the application.
// If the model doesn't already exist, it is created from the application's model.
- (NSManagedObjectModel *)managedObjectModel
{
    if (_managedObjectModel != nil) {
        return _managedObjectModel;                 
    }
    
    _managedObjectModel = [NSManagedObjectModel mergedModelFromBundles:nil];
    return _managedObjectModel;
    
    /*
//     下記の実装だと以下のエラー出現していた
     Cannot create an NSPersistentStoreCoordinator with a nil model
//    momがnilの場合
//    おそらくこのアプリのmomdの場所を変数に格納している
    NSURL *modelURL = [[NSBundle mainBundle] URLForResource:@"BankerMatchCheker" withExtension:@"momd"];
//    momdの場所の情報を元に（おそらくmomdの情報を元に）オブジェクトを生成している
//    定義情報のようなもの？
    _managedObjectModel = [[NSManagedObjectModel alloc] initWithContentsOfURL:modelURL];
    return _managedObjectModel;
     */
}

// Returns the persistent store coordinator for the application.
// If the coordinator doesn't already exist, it is created and the application's store added to it.
//永続ストアコーディネーター
- (NSPersistentStoreCoordinator *)persistentStoreCoordinator
{
    if (_persistentStoreCoordinator != nil) {
        return _persistentStoreCoordinator;
    }
    //DBへのパスを格納
    NSURL *storeURL = [[self applicationDocumentsDirectory] URLByAppendingPathComponent:@"BankerMatchChecker.sqlite"];
    
    NSError *error = nil;
//　momd（永続化する情報（テーブルやカラムそれぞれの情報））を元にpscを生成
    _persistentStoreCoordinator = [[NSPersistentStoreCoordinator alloc] initWithManagedObjectModel:[self managedObjectModel]];
//    
    if (![_persistentStoreCoordinator addPersistentStoreWithType:NSSQLiteStoreType configuration:nil URL:storeURL options:nil error:&error]) {
        /*
         Replace this implementation with code to handle the error appropriately.
         
         abort() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
         
         Typical reasons for an error here include:
         * The persistent store is not accessible;
         * The schema for the persistent store is incompatible with current managed object model.
         Check the error message to determine what the actual problem was.
         
         
         If the persistent store is not accessible, there is typically something wrong with the file path. Often, a file URL is pointing into the application's resources directory instead of a writeable directory.
         
         If you encounter schema incompatibility errors during development, you can reduce their frequency by:
         * Simply deleting the existing store:
         [[NSFileManager defaultManager] removeItemAtURL:storeURL error:nil]
         
         * Performing automatic lightweight migration by passing the following dictionary as the options parameter:
         @{NSMigratePersistentStoresAutomaticallyOption:@YES, NSInferMappingModelAutomaticallyOption:@YES}
         
         Lightweight migration will only work for a limited set of schema changes; consult "Core Data Model Versioning and Data Migration Programming Guide" for details.
         
         */
        NSLog(@"Unresolved error %@, %@", error, [error userInfo]);
        abort();
    }
    
    return _persistentStoreCoordinator;
}

#pragma mark - Application's Documents directory

// Returns the URL to the application's Documents directory.
- (NSURL *)applicationDocumentsDirectory
{
    return [[[NSFileManager defaultManager] URLsForDirectory:NSDocumentDirectory inDomains:NSUserDomainMask] lastObject];
}


@end
