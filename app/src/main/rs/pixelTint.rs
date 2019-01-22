#pragma version(1)
#pragma rs java_package_name(own.lx.renderscript)
#pragma rs rs_fp_relaxed

uchar4 maskColor = {0,0,0,0};

static uchar mixColor(uchar src, uchar mask, float maskAlpha) {
    return (uchar) (src * (1 - maskAlpha) + mask * maskAlpha);
}

uchar4 __attribute__((kernel)) pixelTint(uchar4 in, uint32_t x, uint32_t y) {
    uchar4 out = in;
    float inAlpha = (float) in.a / 255;
    float maskAlpha = (float) maskColor.a / 255;
    float outAlpha = inAlpha + maskAlpha - maskAlpha * inAlpha;

    out.r = mixColor(in.r, maskColor.r, maskAlpha);
    out.g = mixColor(in.g, maskColor.g, maskAlpha);
    out.b = mixColor(in.b, maskColor.b, maskAlpha);
    out.a = (uchar) (outAlpha * 255);

    return out;
}