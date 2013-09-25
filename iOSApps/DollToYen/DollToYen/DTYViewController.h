//
//  DTYViewController.h
//  DollToYen
//
//  Created by 大津 真 on 2012/11/18.
//  Copyright (c) 2012年 BNN. All rights reserved.
//

#import <UIKit/UIKit.h>
#define kDoll @"DollKey"
#define kRate @"RateKey"

@interface DTYViewController : UIViewController <UITextFieldDelegate>
- (void)saveDefault;
- (IBAction)calc:(id)sender;
- (IBAction)backgroundTapped:(id)sender;

@property (weak, nonatomic) IBOutlet UITextField *dollText;
@property (weak, nonatomic) IBOutlet UITextField *rateText;
@property (weak, nonatomic) IBOutlet UILabel *yenLabel;
@end
