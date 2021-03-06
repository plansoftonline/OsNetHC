'use strict';

module.exports = function (grunt) {

  var config = {
    app: 'WebContent/app',
    dist: 'WebContent'
  };

  grunt.initConfig({
    config: config,
    watch: {
      bower: {
        files: ['bower.json'],
        tasks: ['wiredep']
      },
      js: {
        files: ['<%= config.app %>/js/{,*/}*.js']
      },
      gruntfile: {
        files: ['Gruntfile.js']
      },
      styles: {
        files: ['<%= config.app %>/styles/{,*/}*.css']
      }
    },

    browserSync: {
      options: {
        notify: false,
        background: true
      },
      livereload: {
        options: {
          files: [
            '<%= config.app %>/{,*/}*.html',
            '.tmp/styles/{,*/}*.css',
            '<%= config.app %>/images/{,*/}*',
            '<%= config.app %>/styles/{,*/}*.css',
            '<%= config.app %>/js/{,*/}*.js'
          ],
          port: 9000,
          server: {
            baseDir: [config.app]
          }
        }
      }
    },
  wiredep: {
      app: {
        src: ['<%= config.app %>/index.html'],
        ignorePath: /^<%= config.app %>\/|\.\.\//
      }
    },

    uglify: {
      options: {
        mangle: false,
        bautify: true
      },
      my_target: {
        files: [{
          expand: true,
          cwd: '<%= config.app %>/js',
          src: '**/*.js',
          dest: '<%= config.dist %>/js'
        }]
      }
    }
  }); //initConfig

  grunt.registerTask('serve', 'Inicia o servidor', function (target) {

    grunt.task.run([
      'wiredep',
      'browserSync:livereload',
      'watch'
    ]);
  });

  grunt.registerTask('default', [
    'serve'
  ]);

  grunt.registerTask('build', ['uglify']);

  grunt.loadNpmTasks('grunt-wiredep');
  grunt.loadNpmTasks('grunt-browser-sync');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-uglify');
};
