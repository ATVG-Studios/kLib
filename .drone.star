def main(ctx):
  return [
    build(),
    test(),
    docs(),
  ]

def build():
  return {
    "kind": "pipeline",
    "name": "build",
    "steps": [
      {
        "name": "build",
        "image": "gradle:7.0-jdk8",
        "commands": [
          "gradle build",
          "gradle shadowJar"
        ]
      },
      {
        "name": "lint",
        "image": "gradle:7.0-jdk8",
        "commands": [
          "gradle lintKotlin"
        ]
      }
    ]
  }

def docs():
  return {
    "kind": "pipeline",
    "name": "docs",
    "steps": [
      {
        "name": "docs",
        "image": "gradle:7.0-jdk8",
        "commands": [
          "gradle dokkaHtml",
        ]
      }
    ]
  }

def test():
  return {
    "kind": "pipeline",
    "name": "test",
    "steps": [
      {
        "name": "test",
        "image": "gradle:7.0-jdk8",
        "commands": [
          "gradle test",
        ]
      }
    ]
  }
