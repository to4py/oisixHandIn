//
//  ViewController.h
//  PListSample
//
//  Created by fujita taisuke on 2012/08/01.
//  Copyright (c) 2012年 Revolution 9. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController

@property (strong, nonatomic) IBOutlet UITextView *outputDisp;
@property (strong, nonatomic) NSArray *questions;

@property (weak, nonatomic) IBOutlet UIButton *firstAnswer;

- (IBAction)respondToLoadButtonClick:(id)sender;
- (IBAction)respondToFirstAnswer:(id)sender;

@end
