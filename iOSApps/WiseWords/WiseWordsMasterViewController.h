//
//  WiseWordsMasterViewController.h
//  WiseWords
//
//  Created by Yuki Toyoshima on 2013/03/20.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import <UIKit/UIKit.h>

@class WiseWordsDetailViewController;

@interface WiseWordsMasterViewController : UITableViewController

@property (strong, nonatomic) WiseWordsDetailViewController *detailViewController;

@end
