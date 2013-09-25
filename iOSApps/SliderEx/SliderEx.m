//
//  SliderEx.m
//  SliderEx
//
//  Created by Yuki Toyoshima on 2013/04/28.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import "SliderEx.h"

#define BTN_SHOW 0

@implementation SliderEx

- (void)showAlert:(NSString*)title text:(NSString*)text{
    UIAlertView* alert = [[[UIAlertView alloc] initWithTitle:title message:text delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil] autorelease];
    [alert show];
}

- (UIButton*)makeButton:(CGRect)rect text:(NSString*)text tag:(int)tag{
    UIButton* button = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    [button setFrame:rect];
    [button setTitle:text forState:UIControlStateNormal];
    [button setTag:tag];
    [button addTarget:self action:@selector(clickButton:) forControlEvents:UIControlEventTouchUpInside];
    return button;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    _slider = [[UISlider alloc] init];
    [_slider setFrame:CGRectMake(0, 0, 300, 32)];
    [_slider setMinimumValue:0];
    [_slider setMaximumValue:100];
    [_slider setValue:50];
    [self.view addSubview:_slider];
    
    _switch = [[UISwitch alloc] init];
    [_switch setFrame:CGRectMake(0, 50, 200, 32)];
    [_switch setOn:YES];
    [self.view addSubview:_switch];
    UIButton* btnShow = [self makeButton:CGRectMake(0, 100, 90, 40) text:@"表示" tag:BTN_SHOW];
    [self.view addSubview:btnShow];
    // Do any additional setup after loading the view from its nib.
}

- (void)dealloc{
    [_slider release];
    [_switch release];
    [super dealloc];
}

- (IBAction)clickButton:(UIButton*)sender{
    if(sender.tag == BTN_SHOW){
        NSString* switchOn = (_switch.on)?@"ON":@"OFF";
        [self showAlert:@"" text:[NSString stringWithFormat:@"スライダーの値=%d\nスイッチの値=%@", (int)_slider.value, switchOn]];
    }
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
