//
//  PListViewController.m
//  PList
//
//  Created by Yuki Toyoshima on 2013/07/21.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import "PListViewController.h"

@interface PListViewController ()

@end

@implementation PListViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    //NSString *directory = [NSHomeDirectory() stringByAppendingPathComponent:@"Documents"];
    /*
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *directory = [paths objectAtIndex:0];
    
    NSLog(@"directory = %@", directory);
    
    NSString *filePath = [directory stringByAppendingPathComponent:@"wisewords.plist"];
    
    NSLog(@"WiseWords.plist = %@", filePath);
     */
    
    NSBundle* bundle = [NSBundle mainBundle];
    NSString* path = [bundle pathForResource:@"wisewords" ofType:@"plist"];
        
    // ファイルマネージャを作成
    NSFileManager *fileManager = [NSFileManager defaultManager];
    
    // ファイルが存在しないか?
    if (![fileManager fileExistsAtPath:path]) { // yes
        NSLog(@"plistが存在しません．");
        return;
    }
    
    //NSArray* wisewords = [NSArray arrayWithContentsOfFile:path];
    
    NSArray *wiseWords = [[NSArray alloc] initWithContentsOfFile:path];
    if(wiseWords){
        for (NSString *data in wiseWords) {
            NSLog(@"%@", data);
        }
    }
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}



@end
