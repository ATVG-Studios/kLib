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
        "image": "gradle:6.0.1-jdk8",
        "commands": [
          "gradle build",
          "gradle shadowJar"
        ]
      },
      {
        "name": "lint",
        "image": "gradle:6.0.1-jdk8",
        "commands": [
          "bash scripts/ktlint.sh",
          "./ktlint \"src/main/**/*.kt\"",
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
        "image": "gradle:6.0.1-jdk8",
        "commands": [
          "gradle dokka",
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
        "image": "gradle:6.0.1-jdk8",
        "commands": [
          "gradle test",
        ]
      }
    ]
  }
