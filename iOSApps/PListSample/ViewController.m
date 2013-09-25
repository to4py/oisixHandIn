//
//  ViewController.m
//  PListSample
//
//  Created by fujita taisuke on 2012/08/01.
//  Copyright (c) 2012年 Revolution 9. All rights reserved.
//

#import "AppDelegate.h"
#import "ViewController.h"
#import "FirstViewController.h"
#import "Question.h"
#import "Answer.h"

@interface ViewController ()

@end

@implementation ViewController

@synthesize outputDisp, questions, firstAnswer;

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
//    FirstViewController *firstViewController = [[FirstViewController alloc]init];
//    self.questions = firstViewController.questions;
    /*
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *directory = [paths objectAtIndex:0];
    NSString *filePath = [directory stringByAppendingPathComponent:@"data.plist"];
    */
    
    NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
    self.questions = [defaults objectForKey:@"QandA"];
    
    
    if(self.questions){
        
        //今までに使われたQID全てを格納しているリストを取得
        //そのリスト内にないQIDのQを取得したい
        
        //全てのデータを格納したquestionsの一つをデータに格納
        //QごとのIDを格納しているarraylistを取得
        //選択したQのIDが今までに格納した全てのQIDと違っていれば表示処理
        //もし一つとでも同じならばもう一度生成の処理
        
    }
    
    
    /*
    if (self.questions) {
        
        
        
        
        BOOL willReset = NO;
        int rndNum = 0;
        rndNum = arc4random() % 3;
        
        //全てのデータを格納したquestionsの一つをデータに格納
        NSData *data = [self.questions objectAtIndex:rndNum];
        Question *qAndA = [NSKeyedUnarchiver unarchiveObjectWithData:data];
        
        //QごとのIDを格納しているarraylistを取得
        NSMutableArray *qIDStorage = [[defaults objectForKey:@"QIDStorage"] mutableCopy];
        
        //選択したQのIDが今までに格納した全てのQIDと違っていれば表示処理
        //もし一つとでも同じならばもう一度生成の処理
        for (NSNumber *numQID in qIDStorage) {
            //同じIDがある場合、もう一度
            if (qAndA.qID == numQID) {
                
                willReset = NO;
                break;
            }else{
                willReset = NO;
            }
        
                        
        }
        
        if (!willReset) {
            outputDisp.text = qAndA.question;
            [firstAnswer.titleLabel setText:qAndA.answer1.answer];
            
            NSNumber *test = qAndA.qID;
            
            [qIDStorage addObject:test];
            
            [defaults setObject:qIDStorage forKey:@"QIDStorage"];
            [defaults synchronize];
        }else{
                NSLog(@"%@", @"リセットフラグが立っています。");
        }
    
        
        
    }else{
        NSLog(@"%@", @"データが存在しません。");
    }
     */

    
    
}

- (void)viewDidUnload
{
    [self setOutputDisp:nil];
    [self setFirstAnswer:nil];
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    
    
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

- (IBAction)respondToLoadButtonClick:(id)sender
{
         
//    
//    if (array) {
//        for (NSString *data in array) {
//            NSLog(@"%@", data);
//        }
//    } else {
//        NSLog(@"%@", @"データが存在しません。");
//    }
}

- (IBAction)respondToFirstAnswer:(id)sender {
}

@end
