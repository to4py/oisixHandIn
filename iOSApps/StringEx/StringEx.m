//
//  StringEx.m
//  StringEx
//
//  Created by Yuki Toyoshima on 2013/03/28.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import "StringEx.h"

@implementation StringEx

- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        // Initialization code
    }
    return self;
}

- (void)setColor_r:(int)r g:(int)g b:(int)b{
    [[UIColor colorWithRed:r/255.0f green:g/255.0f blue:b/255.0f alpha:1.0f] set];
}

- (void)drawString:(NSString*)string x:(float)x y:(float)y font:(UIFont*)font{
    [string drawAtPoint:CGPointMake(x, y) withFont:font];
}

- (id)initWithCoder:(NSCoder *)coder{
    self = [super initWithCoder:coder];
    if(self){
    }
    return self;
}

- (void)drawRect:(CGRect)rect
{
    UIFont* font = [UIFont systemFontOfSize:24];
    
    [self setColor_r:0 g:100 b:0];
    
    [self drawString:[NSString stringWithFormat:@"画面サイズ：%dx%d", (int)[UIScreen mainScreen].bounds.size.width, (int)[UIScreen mainScreen].bounds.size.height] x:0 y:0  font:font];
    
    CGSize size = [@"A" sizeWithFont:font];
    [self drawString:[NSString stringWithFormat:@"文字幅：%d", (int)size.width] x:0 y:30 font:font];
    
    font = [UIFont systemFontOfSize:15];
    [self setColor_r:255 g:0 b:0];
    [self drawString:@"12dot" x:0 y:30*3 font:font];
    
    font = [UIFont systemFontOfSize:24];
    [self setColor_r:0 g:0 b:255];
    [self drawString:@"24dot" x:0 y:30*4 font:font];
}


@end
