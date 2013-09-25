//
//  WiseWordsDetailViewController.h
//  WiseWords
//
//  Created by Yuki Toyoshima on 2013/03/20.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface WiseWordsDetailViewController : UIViewController <UISplitViewControllerDelegate>

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UILabel *detailDescriptionLabel;
@end
