//
//  AppDelegate.m
//  PListSample
//
//  Created by fujita taisuke on 2012/08/01.
//  Copyright (c) 2012年 Revolution 9. All rights reserved.
//

#import "AppDelegate.h"
#import "Question.h"
#import "Answer.h"
#import "ViewController.h"
@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    // Override point for customization after application launch.
    
    //Question1
    Question *question1 = [[Question alloc] init];
    question1.question = @"飲み会は好きですか？";
    question1.qID = [NSNumber numberWithInt:1];
    
    Answer *answer1 = [[Answer alloc] init];
    answer1.answer = @"アル中とは俺のこと！";
    answer1.point = [NSNumber numberWithInt:1];;
    
    Answer *answer2 = [[Answer alloc] init];
    answer2.answer = @"まーちょいちょいみたいな？";
    answer2.point = [NSNumber numberWithInt:2];
    
    Answer *answer3 = [[Answer alloc] init];
    answer3.answer = @"遺伝的に弱いぜ";
    answer3.point = [NSNumber numberWithInt:3];
    
    question1.answer1 = answer1;
    question1.answer2 = answer2;
    question1.answer3 = answer3;
    
    //Question2
    Question *question2 = [[Question alloc] init];
    question2.question = @"学生時代に体育会系の部活に所属していましたか？";
    question2.qID = [NSNumber numberWithInt:2];
    
    answer1 = [[Answer alloc] init];
    answer1.answer = @"していた";
    answer1.point = [NSNumber numberWithInt:1];;
    
    answer2 = [[Answer alloc] init];
    answer2.answer = @"軽い感じのにしていた";
    answer2.point = [NSNumber numberWithInt:2];
    
    answer3 = [[Answer alloc] init];
    answer3.answer = @"私はちょー文化系でした";
    answer3.point = [NSNumber numberWithInt:3];
    
    question2.answer1 = answer1;
    question2.answer2 = answer2;
    question2.answer3 = answer3;
    
    //Question3
    Question *question3 = [[Question alloc] init];
    question3.question = @"SなのMなの？";
    question3.qID = [NSNumber numberWithInt:3];
    
    answer1 = [[Answer alloc] init];
    answer1.answer = @"どS！";
    answer1.point = [NSNumber numberWithInt:1];;
    
    answer2 = [[Answer alloc] init];
    answer2.answer = @"まぁ普通";
    answer2.point = [NSNumber numberWithInt:2];
    
    answer3 = [[Answer alloc] init];
    answer3.answer = @"Mっすね";
    answer3.point = [NSNumber numberWithInt:3];
    
    question3.answer1 = answer1;
    question3.answer2 = answer2;
    question3.answer3 = answer3;





    
    
    NSData *data = [NSKeyedArchiver archivedDataWithRootObject:question1];
    NSData *data2 = [NSKeyedArchiver archivedDataWithRootObject:question2];
    NSData *data3 = [NSKeyedArchiver archivedDataWithRootObject:question3];
    
//    ViewController *quizViewController = [[ViewController alloc]init];
//    
//    quizViewController.questions = @[data, data2, data3];
    /*
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *directory = [paths objectAtIndex:0];
    NSString *filePath = [directory stringByAppendingPathComponent:@"data.plist"];
    */
    
    NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
    [defaults setObject:@[data, data2, data3] forKey:@"QandA"];
    
    NSMutableArray *qIDStorage = [NSMutableArray array];
    NSNumber *num = [NSNumber numberWithInt:1];
    [qIDStorage addObject:num];
    [defaults setObject:qIDStorage forKey:@"QIDStorage"];
    
    BOOL successful = [defaults synchronize];
    if (successful) {
        NSLog(@"%@", @"初期データの保存に成功しました。");
    }
    
    NSLog(@"アプリを起動しました！");
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

@end
