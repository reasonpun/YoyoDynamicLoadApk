# YoyoDynamicLoadApk
this is fork https://github.com/singwhatiwanna/dynamic-load-apk

but

i need gradle and more features,

so, i build this by gradle in Android Studio.

then,

more samples will be added soon...

here, I added

  * (butterknife)[https://github.com/JakeWharton/butterknife]
  * (picasso)[https://github.com/square/picasso]
  * and network-lib.arr in plugin-a (that is lib for httprequest and used (OkHttp)[https://github.com/square/okhttp], (Volley)[https://github.com/mcxiaoke/android-volley] source code will be coming soon...)

something attention

```code
    // for butterknife, need "this" to inject views
    ButterKnife.bind(this);
```

and

```code
    // but for picasso, need "that"
    Picasso.with(that).load("http://f.hiphotos.baidu.com/image/h%3D360/sign=6fe50562ed50352aae61230e6342fb1a/f11f3a292df5e0fecc3383d4586034a85edf723f.jpg").into(mImage);
```

## Thanks singwhatiwanna, and updated by reason <reasonpun@gmail.com>

## License

    Copyright (C) 2014 singwhatiwanna(任玉刚) <singwhatiwanna@gmail.com>

    collaborator:田啸,宋思宇

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.