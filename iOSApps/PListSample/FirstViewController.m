//
//  FirstViewController.m
//  PListSample
//
//  Created by Yuki Toyoshima on 2013/07/22.
//  Copyright (c) 2013年 Revolution 9. All rights reserved.
//

#import "FirstViewController.h"
#import "ViewController.h"
#import "Question.h"
#import "Answer.h"

@interface FirstViewController ()

@end

@implementation FirstViewController

@synthesize questions;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
    //ViewController *vController = [[ViewController alloc] init];
            
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

//- (IBAction)respondToStart:(id)sender {
//    
//    ViewController *quizDispViewController = [[ViewController alloc]init];
//    quizDispViewController.questions = self.questions;
//    
//    [self presentViewController:quizDispViewController animated:YES completion:nil];
//    
//}
@end
